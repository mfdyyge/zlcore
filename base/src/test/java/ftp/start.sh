#!/bin/bash
ROOT=$(cd `dirname $0`; pwd)
echo $ROOT
CPP=.:$ROOT/config
for i in `ls $ROOT/lib`
do
	temp=$ROOT/lib/$i
	CPP=$CPP:$temp
done
echo $CPP
 java -cp $CPP  -Dbase.path=$ROOT com.zl.base.ftp.server.Main
