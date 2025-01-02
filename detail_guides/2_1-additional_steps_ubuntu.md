# Step 2_1 - Make a Server out of your machine

- go to your admin machine --> bash
- create a folder "git"
```bash
mkdir git
cd git
```
- clone the workshop repo repository
```bash
git clone https://github.com/hackerbande-nbg/decentralize-your-internet.git
```
- publish the public key of your admin machine via http
```bash
cd decentralize-your-internet/scripts/step_3
python3 publish_public_key.py
```

## Check that python is installed on the admin machine
- run git bash
- type 
```python
python3 --version
```
- if you get a version number, you are good to go
- if not, install python for windows: https://www.python.org/downloads/windows/


topics:
- git

Topics
- ssh keys