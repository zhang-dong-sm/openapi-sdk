#!/bin/bash

#获取执行脚本所在的绝对路径
SCRIPT_ABSOLUTE_PATH=`readlink -f $0`
SCRIPT_PARENT_DIR=`dirname $SCRIPT_ABSOLUTE_PATH`

rm -rf ${SCRIPT_PARENT_DIR}/output
mkdir ${SCRIPT_PARENT_DIR}/output

projects=`find ${SCRIPT_PARENT_DIR} -maxdepth 1 -mindepth 1 ! -name '.*' ! -name 'output' -type d`

for project_path in ${projects}; do
  project_name=`basename ${project_path}`
  if [[ -f ${project_path}/generate-html.sh ]]; then
    echo "正在执行项目 ${project_name}"
    cd ${project_path}
    chmod +x ${project_path}/generate-html.sh
    ${project_path}/generate-html.sh
    cd ${SCRIPT_PARENT_DIR}
    cp ${project_path}/output/index.html ${SCRIPT_PARENT_DIR}/output/${project_name}.html
  else
    echo "跳过忽略项目 ${project_name}：缺少 generate-html.sh 文件"
  fi
done