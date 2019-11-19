package cn.halfangel.controller;

import cn.halfangel.rpc.properties.ResultStr;
import cn.halfangel.rpc.service.TestThriftService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class LoginController {
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request) {

        TSocket m_transport = new TSocket("localhost", 12356,2000);
        TProtocol protocol = new TBinaryProtocol(m_transport);
        TestThriftService.Client testClient = new TestThriftService.Client(protocol);

        try {
            m_transport.open();

            ResultStr t = testClient.getStr("test1", "test2");
            m_transport.close();
        } catch (TException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
