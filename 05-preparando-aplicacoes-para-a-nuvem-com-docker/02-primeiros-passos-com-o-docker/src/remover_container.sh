#!/bin/bash
#
# Remove todos os containers
# Descomente a linha docker rm para apagar seus containers.
# Atenção: Após executar, não será possível desfazer.
# Como utilizar o script:
#   - Transforme o arquivo é um script executável:
#   > chmod +x remover_container.sh
#   - Execute o script:
#   > ./remover_container.sh
#
for f in `docker ps -a | awk '{print $1}' | grep '[a-z|0-9]'`
do
echo 'Removendo container' $f
# docker rm -f $f
done
exit 0