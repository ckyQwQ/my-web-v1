package cn.halfangel.rpc.service.impl;

import cn.halfangel.rpc.properties.ResultInt;
import cn.halfangel.rpc.properties.ResultStr;
import cn.halfangel.rpc.properties.ThriftResult;
import cn.halfangel.rpc.service.TestThriftService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestThriftServiceImpl implements TestThriftService.Iface {

    @Override
    public ResultStr getStr(String srcStr1, String srcStr2) {

        System.out.println("[getStr] receive:" + "s1:" + srcStr1 + " . " + "s2:" + srcStr2 + "\n");
        String res = srcStr1 + srcStr2;
        System.out.println("[getStr] merge:" + res + "\n");

        return new ResultStr(ThriftResult.SUCCESS, res);
    }

    @Override
    public ResultInt getInt(int val) {
        long startTime = System.currentTimeMillis();
        int res = val * 10;
        long stopTime = System.currentTimeMillis();

        System.out.println("[getInt]time interval: " + (stopTime - startTime));

        return new ResultInt(ThriftResult.SUCCESS, res);
    }
}
