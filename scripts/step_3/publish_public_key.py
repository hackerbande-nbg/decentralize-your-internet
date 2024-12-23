import http.server
import socketserver
from pathlib import Path
import socket

PORT = 6666
PUB_KEY_FILE = "id_rsa.pub"

class PublicKeyHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        """
        Serve the id_rsa.pub file if requested, otherwise respond with 404.
        """
        if self.path == "/":
            file_path = Path(PUB_KEY_FILE)
            if file_path.is_file():
                self.send_response(200)
                self.send_header("Content-type", "text/plain")
                self.end_headers()
                with open(file_path, "rb") as file:
                    self.wfile.write(file.read())
            else:
                self.send_response(404)
                self.end_headers()
                self.wfile.write(b"Error: id_rsa.pub not found.")
        else:
            self.send_response(404)
            self.end_headers()
            self.wfile.write(b"Error: Invalid path.")

def get_ip_address():
    """
    Retrieve the local IP address of the machine.
    """
    hostname = socket.gethostname()
    return socket.gethostbyname(hostname)

def main():
    """
    Start the HTTP server on port 6666 and print success message with wget command.
    """
    ip_address = get_ip_address()
    with socketserver.TCPServer(("", PORT), PublicKeyHandler) as httpd:
        print("Server started successfully!")
        print(f"Access the public key using the following command:")
        print(f"wget http://{ip_address}:{PORT}/")
        print(f"Server is running at http://{ip_address}:{PORT}/")
        print(f"remember to shut this down afterwards!")
        httpd.serve_forever()

if __name__ == "__main__":
    main()
