#!/bin/bash

# Obtener la ruta actual del script
script_dir="$(cd "$(dirname "${deploy_coffee_machines[0]}")" && pwd)"

# Construir la ruta completa de la carpeta "libs"
libs_folder="$script_dir/build/libs"

# Cantidad de máquinas de café a desplegar en cada computadora
cantidad_maquinas=3

# Puerto inicial para las máquinas de café
puerto_inicial=9040

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

    # Nombre de la carpeta
    nombre_carpeta="coffeeMachines_jjdd_finalProject"

    # Directorio de destino en el computador externo
    destino="/home/swarch/$nombre_carpeta"

    # Crear una carpeta de destino en el computador externo
    ssh swarch@"$ip" "mkdir -p $destino"

    # Copiar la carpeta "Libs" al computador externo
    scp -r "$libs_folder" swarch@"$ip":"$destino"

    # Desplegar las máquinas de café en el computador externo
    for ((i=1; i<=$cantidad_maquinas; i++))
    do
        # Aumentar número de puerto
        puerto=$((puerto_inicial + i))

        # Realizar despliegue
        ssh swarch@"$ip" "cd $destino/Libs && sed -i 's/-p 12346/-p $puerto/' coffeMach.cfg && java -jar coffeMach.jar"
        
        echo "Despliegue maquina $i completado en $ip"
    done
done