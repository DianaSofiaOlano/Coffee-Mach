#!/bin/bash

# Definir una lista de direcciones IP de las computadoras externas
ip_list=(
  "10.147.19.157"
  "10.147.19.126"
  "10.147.19.34"
  "10.147.19.26"
  "10.147.19.123"
  "10.147.19.179"
  "10.147.19.158"
  "10.147.19.125"
  "10.147.19.95"
  "10.147.19.107"
  "10.147.19.220"
  "10.147.19.100"
  "10.147.19.237"
  "10.147.19.30"
  "10.147.19.121"
  "10.147.19.115"
  "10.147.19.42"
  "10.147.19.65"
  "10.147.19.50"
  "10.147.19.2"
  "10.147.19.122"
  "10.147.19.207"
  "10.147.19.252"
  "10.147.19.63"
  "10.147.19.219"
  "10.147.19.69"
  "10.147.19.228"
  "10.147.19.224"
  "10.147.19.236"
  "10.147.19.212"
)

for ip in "${ip_list[@]}"
do
    echo "Desplegando máquina de café en $ip..."

    # Obtener la ruta actual del script
    script_dir="$(cd "$(dirname "${deploy_coffee_machines[0]}")" && pwd)"

    # Construir la ruta completa para modificar el archivo coffeeMach.cfg
    machConfiguration="$script_dir/src/main/resources/coffeMach.cfg"

    # Modificar la dirección IP
    sed -i "s/CoffeMach.Endpoints = tcp -h localhost -p 12346/CoffeMach.Endpoints = tcp -h $ip -p 12346/g" $machConfiguration

    # Build
    cd "$script_dir" && gradle -p coffeeMach build

    # Construir la ruta completa de la carpeta "libs"
    libs_folder="$script_dir/build/libs"

    # Nombre de la carpeta que se creará en el computador externo
    carpeta_externa="coffeeMachines_jjdd_finalProject"

    # Directorio de destino en el computador externo
    destino="/home/swarch/$carpeta_externa"

    # Verificar si la carpeta de destino existe en el computador externo y borrarla si es así
    sshpass -p "swarch" swarch@"$ip":"if [ -d $destino ]; then rm -rf $destino; fi"

    # Crear una carpeta de destino en el computador externo
    sshpass -p "swarch" swarch@"$ip":"mkdir -p $destino"

    # Copiar la carpeta "Libs" al computador externo
    sshpass -p "swarch" scp -r "$libs_folder" swarch@"$ip":"$destino"
        
    echo "Despliegue maquina $i completado en $ip"
done