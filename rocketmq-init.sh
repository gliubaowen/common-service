#!/bin/bash

# -------------------------------------------------------------------------------
# Filename:    rocketmq-init.sh 
# Version:     2.0.0
# Date:        2019-10-16
# Author:      LiuBaoWen
# Email:       bwliush@cn.ibm.com
# Description: 初始化rocketmq
# Notes:       待测试
# -------------------------------------------------------------------------------

cd $ROCKETMQ_HOME

#Start Name Server
./bin/mqnamesrv.sh

#Start Broker
./bin/mqbroker.sh -n localhost:9876

#Send & Receive Messages
export NAMESRV_ADDR="localhost:9876"
./bin/tools.sh org.apache.rocketmq.example.quickstart.Producer
./bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer

#Shutdown Servers
#./bin/mqshutdown.sh broker
#./bin/mqshutdown.sh namesrv

