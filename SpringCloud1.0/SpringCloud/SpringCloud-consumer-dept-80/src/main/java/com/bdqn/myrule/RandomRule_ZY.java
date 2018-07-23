package com.bdqn.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class RandomRule_ZY extends AbstractLoadBalancerRule {

    private int total = 0; 			// 总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0;	// 当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key)
    {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            //判断线程是否中断
            if (Thread.interrupted()) {
                return null;
            }
            //得到在线的服务
            List<Server> upList = lb.getReachableServers();
            //得到所有服务
            List<Server> allList = lb.getAllServers();
            //获取服务数量
            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes only get more
                 * restrictive.
                 */
                return null;
            }

//			int index = rand.nextInt(serverCount);// java.util.Random().nextInt(3);
//			server = upList.get(index);


//			private int total = 0; 			// 总共被调用的次数，目前要求每台被调用5次
//			private int currentIndex = 0;	// 当前提供服务的机器号
            if(total < 5)
            {
                //得到相应下标的服务
                server = upList.get(currentIndex);
                //服务调用次数加一
                total++;
            }else {
                total = 0;
                //服务下标加一
                currentIndex++;
                //如果服务的下标大于或等于服务的总数，那么服务的下标从零重新开始
                if(currentIndex >= upList.size())
                {
                    currentIndex = 0;
                }
            }

            //如果服务为空，中断执行，继续下一轮
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were somehow trimmed.
                 * This is a transient condition. Retry after yielding.
                 */
                Thread.yield();
                continue;
            }
            //判断当前线程是否处于活动状态
            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }


    public Server choose(Object key)
    {
        return choose(getLoadBalancer(), key);
    }


    public void initWithNiwsConfig(IClientConfig clientConfig)
    {
        // TODO Auto-generated method stub

    }
}
