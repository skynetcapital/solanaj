package org.p2p.solanaj.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.p2p.solanaj.rpc.types.*;
import org.p2p.solanaj.rpc.*;

public class  BlockTest{
    private final RpcClient client = new RpcClient(Cluster.MAINNET);

    @Test
    public void getConfirmedBlockTest() {
            try{
             
              Block result2=  client.getApi().getConfirmedBlock(77195000);

              assertNotNull(result2);
              assertNotNull(result2.getTransactions());
            }  catch (RpcException e) {
                e.printStackTrace();
                         }
    }

    //TODO: Test Block class itself
    //more advanced rpc calls with optional params.
}