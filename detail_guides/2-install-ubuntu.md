# Step 2 - Install Ubuntu

## Create Ubuntu Setup Stick

### DL ubuntu
download 22.04 LTS latest version (https://ubuntu.com/download/server)

### Install rufus

- download rufus https://rufus.ie/en/ (version 4.6)
- run rufus.exe
- Rufus Update Policy --> Yes

### Run rufus

- Device: select your USB Stick (e.g. mine was on D:)
- be sure that you selected the correct stick or better, unplug all other USB sticks and disks
- Boot selection: Disk or ISO image (Please select)
- Select button: select the downloaded .iso file (ubuntu-24.04.1-live-server-amd64.iso)
- Partition scheme: MBR
- Target System: BIOS or UEFI
- Volume label: we-have-internet-at-home
- File system: FAT32
- Cluster size: 4096 bytes (Default)
- Push START
- ISOHybrid image detected: Write in ISO mode (recommended)
- Push OK
- Another Program is using this drive: Push Yes
- Warning: All data on device 'D:' will be destroyed: Push OK
- wait patiently (7 minutes for me)
- Push Close

## Install ubuntu

- insert the boot stick into the target machine
- boot the target machine
- find out your boot key, this depends on your hardware
  - here is a list for most manufacturers: https://www.disk-image.com/faq-bootmenu.htm
  - if you don't find your manufacturer, try in this order: F2, ESC, F10, F12, DEL, TAB 
  - use separate reboots
  - this is as stupid as it sounds
- start the machine
- frantically hit the boot key
- in the boot menu, select the boot stick  

- <details>
    <summary>Dell Latitude E6230</summary>
  For the Dell Latitude E6230 it was very important to boot the Ubuntu install USB stick already in UEFI mode (*not* Legacy Mode).
  To achieve this, it was necessary to boot to Bios Setup (Hit F2 during "Dell" Splash Screen), disable Legacy Boot Option, disable Secure Boot and *manually* add a UEFI Boot Option. It was not automatically in the boot sequence list. 

  - Add Option  
  - Navigate through the file selection list somewhere to a sub dir named grub2 and select the file inside.  
  - cannot remember anymore in detail unfortunately :(    
  </details> 

- select "Install ubuntu"
- select your language ("English")
- select your keyboard layout, via the identify option ("German")
- choose "Ubuntu Server" for base installation
- add a network connection
  - preferably via LAN
  - otherwise add wifi, although that leads to unstable setups
- test the update Archives
- Guided storage configuration: use the Default
- storage configuration: press Done
- start installation: Continue
- Profile configuration: add your name, your server name, your username, and your password
  - In this tutorial we assume at some points that you created your new user as user name "cloudy". In case you choose to use another one (how dare you! :O ), please keep that in mind.
- remember your password
- Ubuntu ProSetup: skip
- SSH configuration: enable Install OpenSSH server
- Be patient once more. This can take a while, especially the "Installing Kernel" step.
- Reboot after install
- you successfully installed ubuntu!

- update your machine:
```bash
sudo apt update && sudo apt upgrade -y
```
- Reboot machine:
```bash
sudo reboot now
```
