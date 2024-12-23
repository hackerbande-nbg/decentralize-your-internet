# Nextcloud setup trusted domain
Nextcloud will check if you are accessing it from the same domain, like you set it up from in the beginning.
If you changed this domain later (e.g. because you set it up before configuring internet access and now you want to access it not via local IP, but via a real domain) an internal config needs to be changed.

Here is one way to do it.
- Identify your nextcloud config volume:  
    ```docker volume ls```
- spin up a temporary docker container, which has nano, mount the config volume and edit it:  
    ```docker run --rm -it -v 38c3.fun_nextcloud_config:/mnt/config ubuntu bash -c "apt-get update && apt-get install -y nano && nano /mnt/config/config.php"```
- in nano, change the item 0 of array "trusted domains" to your real domain:  
    - Before:  
    ![trusted domains before change](images/config_php_domain_before.png)
    - After:   
    ![trusted domains before change](images/config_php_domain_after.png)