<#
# Filename:    rocketmq-init.ps1 
# Version:     0.0.1
# Date:        2019-10-16
# Author:      LiuBaoWen
# Email:       bwliush@cn.ibm.com
# Description: 初始化rocketmq
# Notes:       待测试
#>

# 声明采用UTF-8编码
chcp 65001

Write-Host $(Get-Date) "初始化rocketmq开始"

cd $env:ROCKETMQ_HOME

#Start Name Server
start .\bin\mqnamesrv.cmd

#Start Broker
start .\bin\mqbroker.cmd -n localhost:9876

#Send & Receive Messages
$env:NAMESRV_ADDR="localhost:9876"
start .\bin\tools.cmd org.apache.rocketmq.example.quickstart.Producer
start .\bin\tools.cmd org.apache.rocketmq.example.quickstart.Consumer

#Shutdown Servers
#start .\bin\mqshutdown.cmd broker
#start .\bin\mqshutdown.cmd namesrv

Write-Host $(Get-Date) "初始化rocketmq完成"

pause
