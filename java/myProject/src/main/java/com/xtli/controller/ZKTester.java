/*package com.xtli.controller;

import java.util.Map;
import java.util.Set;
import org.apache.zookeeper.ZooKeeper;
import com.zuche.framework.remote.nio.codec.HessianSerializerUtils;
import com.zuche.framework.remote.vo.RemoteServiceVO;
public class ZKTester {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		//ZooKeeper zooKeeper = new ZooKeeper("10.101.22.31:5181", 300000, null);
		//ZooKeeper zooKeeper = new ZooKeeper("10.101.22.119:5181", 300000, null);
		ZooKeeper zooKeeper = new ZooKeeper("10.159.22.144:5181", 300000, null);
		
		//byte[] data = zooKeeper.getData("/ucar/remoteService/manager", null, null);
		byte[] data = zooKeeper.getData("/zuche/remoteService/manager", null, null);
		Object obj = HessianSerializerUtils.deserialize(data);
		Map<String, RemoteServiceVO> map = (Map<String, RemoteServiceVO>)obj;
		System.out.println(map.size());
		Set<Map.Entry<String, RemoteServiceVO>> sets = map.entrySet();
		for(Map.Entry<String, RemoteServiceVO> entry:sets){
			//要查询的服务名字
			String serviceName = "carcrm.memberBalanceRemoteService.";
			if(entry.getKey().indexOf(serviceName)>-1){
				//能打印则证明服务在zk注册
				System.out.println(entry.getKey()+"----"+entry.getValue().getBeanId());
			}
		}
		System.out.println("over");
		
	}
}
*/