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
  # Resto de las direcciones IP...
)

for ip in "${ip_list[@]}"
do
    echo "Desplegando máquina de café en $ip..."

    # Nombre de la carpeta
    nombre_carpeta="coffeeMachines_jjdd_finalProject"

    # Directorio de destino en el computador externo
    destino="/home/swarch/$nombre_carpeta"

    # Verificar si la carpeta de destino existe en el computador externo y borrarla si es así
    ssh swarch@"$ip" "if [ -d $destino ]; then rm -rf $destino; fi"

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