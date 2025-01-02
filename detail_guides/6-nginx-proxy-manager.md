# Configure NGINX Proxy Manager
## Setup Port Forwarding on your router
On your Router, you need to allow SSL encrypted requests from the internet to pass into your network and be processed by your server (namely NGINX Proxy Manager, which we will setup in the next step). 

**PLEASE PAY ATTENTION: in this step, you WILL OPEN YOUR SETUP TO THE INTERNET! Be sure that you want this and know that the world can access your setup.
Make sure your System is up to date and you have backups of your data.**

### FritzBox
In a Fritzbox router, this can be configured under Internet -> Permit Access -> Port Sharing.
Add a new Device for Sharing, select your server and set internal and external port as 443. Repeat the same for port 80.  
<details>
<summary>Explanation</summary>
We intend to only use https (443) but for requesting a Let's Encrypt certificate, the NGINX Proxy Manager needs to be reachable via port 80, as we don't have an SSL certificate at that point. For more info see this [Let's Encrypt Blogpost](https://letsencrypt.org/docs/allow-port-80/).
</details>  


Result should look something like this:
![Fritzbox Port Forwarding](../images/fritzbox_port_forwarding.png)

## Initial Login
On your admin machine, open a browser and browse to http://<target machine IP>:81 
When logging in the first time, you need to use the following predefined credentials:
- admin@axample.com
- changeme

After logging in, system will prompt you to setup a real admin account and disable the default one.

## Setup SSL certificate
- Navigate to "SSL certificates" in the menu ribbon
- Click Button "Add SSL certificate"
- In "Domain Names", enter the domain you created earlier
    - Important: after you typed the domain, use your mouse and click on the "add <domain>" lable below the input field, otherwise you will lose your input and need to type again
- Click on "Test Server Reachability"
    - Should display "Your server is reachable and creating certificates should be possible."
    - Accept Let's Encrypt TOS and click "Save"  
        ![Create Certificate](../images/NPM_cert.png)

## Setup Proxy Host
- Navigate to "Hosts" -> "Proxy Hosts"
- Click Button "Add Proxy Host"
    - Details
        - Domain Names
            - Enter the domain you created earlier
                - Important: after you typed the domain, use your mouse and click on the "add <domain>" lable below the input field, otherwise you will lose your input and need to type again
        - Scheme
            - http
        - Forward Hostname/IP
            - IP of target machine
                - ATTENTION: It is important that your target machine always obtains the same IP, otherwise, this routing will become outdated, when the target machine obtains another IP in the future. Usually, a permanent IP address for any network device can be set in your router. 
        - Forward Port
            - 8092
        - Toggle "Block Common Exploits", keep rest as default
        ![Host Details](../images/NPM_Host_Details.png)
    - Custom locations
        - Keep default
    - SSL
        - SSL Certificate
            - Select the SSL certificate created above under [Setup SSL certificate](#setup-ssl-certificate)
        - Toggle "Force SSL", "HTTP/2 Support", "HSTS Enabled", keep rest default
        ![Host SSL](NPM_Host_SSL.png)
    - Advanced
        - Keep default
    - Click "Save"
