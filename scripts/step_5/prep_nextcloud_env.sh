#!/bin/bash

echo "Creating folders..."
HOME_DIR="$HOME"

cd "$HOME_DIR" || exit 1

mkdir -p nextcloud_data nextcloud_logs nextcloud_ssl nextcloud_html nextcloud_infra nextcloud_keys

echo "Copying infra files..."
if [ -d "decentralize-your-internet/infra/nextcloud" ]; then
    cp decentralize-your-internet/infra/nextcloud/compose.yml nextcloud_infra/
    cp decentralize-your-internet/infra/nextcloud/.env.example nextcloud_infra/.env
else
    echo "Error: Source directory 'decentralize-your-internet/infra/nextcloud' not found!"
    exit 1
fi

chmod 644 "$HOME_DIR/nextcloud_infra/compose.yml"
chmod 600 "$HOME_DIR/nextcloud_infra/.env"

echo "Adjusting permissions for Jenkins..."
sudo chmod 711 "$HOME_DIR"  # Nur Lesen und Ausführen für andere
sudo chmod 777 "$HOME_DIR"  # Entfernt, da es zu unsicher ist

cd nextcloud_infra || exit 1

echo ""
echo -e "\e[94m!!! Check '$HOME_DIR/nextcloud_infra/.env' and adjust DB secret and project names if necessary !!!\e[0m"
echo ""