@REM ------------------------------------
@REM Filename:    rocketmq-init.ps1 
@REM Version:     0.0.1
@REM Date:        2019-10-16
@REM Author:      LiuBaoWen
@REM Email:       bwliush@cn.ibm.com
@REM Description: 初始化rocketmq
@REM Notes:       待测试
@REM ------------------------------------

echo "初始化rocketmq开始"

#未测试通过
cd %ROCKETMQ_HOME% 

#Start Name Server
call .\bin\mqnamesrv.cmd

#Start Broker
call .\bin\mqbroker.cmd -n localhost:9876

#Send & Receive Messages
set NAMESRV_ADDR="localhost:9876"
call .\bin\tools.cmd org.apache.rocketmq.example.quickstart.Producer
call .\bin\tools.cmd org.apache.rocketmq.example.quickstart.Consumer

#Shutdown Servers
#call .\bin\mqshutdown.cmd broker
#call .\bin\mqshutdown.cmd namesrv

echo "初始化rocketmq完成"

pause