package org.p2p.solanaj.rpc.types;

import com.squareup.moshi.Json;
import java.util.List;

public class Block {

public static class Status {
    @Json(name = "Ok")
    private Object ok;

    public Object getOk() {
        return ok;
    }
}

public static class Meta {

    @Json(name = "err")
    private Object err;
    @Json(name = "fee")
    private long fee;
    @Json(name = "innerInstructions")
    private List<Object> innerInstructions = null;
    @Json(name = "postBalances")
    private List<Long> postBalances = null;
    @Json(name = "preBalances")
    private List<Long> preBalances = null;
    @Json(name = "status")
    private Status status;

    public Object getErr() {
        return err;
    }

    public long getFee() {
        return fee;
    }

    public List<Object> getInnerInstructions() {
        return innerInstructions;
    }

    public List<Long> getPostBalances() {
        return postBalances;
    }

    public List<Long> getPreBalances() {
        return preBalances;
    }

    public Status getStatus() {
        return status;
    }

}

public static class Reward{
    @Json(name = "pubkey")
    private String pubkey;
    @Json(name = "lamports")
    private long lamports;
    @Json(name = "postBalance")
    private long postBalance;//diff between i64 and u64 in java?
    @Json(name = "rewardType")
    private String rewardType;
}
public static class Header {

    @Json(name = "numReadonlySignedAccounts")
    private long numReadonlySignedAccounts;
    @Json(name = "numReadonlyUnsignedAccounts")
    private long numReadonlyUnsignedAccounts;
    @Json(name = "numRequiredSignatures")
    private long numRequiredSignatures;

    public long getNumReadonlySignedAccounts() {
        return numReadonlySignedAccounts;
    }

    public long getNumReadonlyUnsignedAccounts() {
        return numReadonlyUnsignedAccounts;
    }

    public long getNumRequiredSignatures() {
        return numRequiredSignatures;
    }

}

public static class Instruction {

    @Json(name = "accounts")
    private List<Long> accounts = null;
    @Json(name = "data")
    private String data;
    @Json(name = "programIdIndex")
    private long programIdIndex;

    public List<Long> getAccounts() {
        return accounts;
    }

    public String getData() {
        return data;
    }

    public long getProgramIdIndex() {
        return programIdIndex;
    }

}

public static class Message {

    @Json(name = "accountKeys")
    private List<String> accountKeys = null;
    @Json(name = "header")
    private Header header;
    @Json(name = "instructions")
    private List<Instruction> instructions = null;
    @Json(name = "recentBlockhash")
    private String recentBlockhash;

    public List<String> getAccountKeys() {
        return accountKeys;
    }

    public Header getHeader() {
        return header;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public String getRecentBlockhash() {
        return recentBlockhash;
    }

}

//**wait does this mean i don't need it to be in the constructor?? */
public static class Transaction {

    @Json(name = "message")
    private Message message;
    @Json(name = "signatures")
    private List<String> signatures = null;

    public Message getMessage() {
        return message;
    }

    public List<String> getSignatures() {
        return signatures;
    }

}

@Json(name = "meta")
private Meta meta;
public Meta getMeta(){
    return meta;
}

//meta too.
    // public Block(long blockTime, String blockhash, long parentSlot,
    //  String previousBlockhash) {
    //      this.blockTime =blockTime;
    //      this.blockhash = blockhash;
    //      this.parentSlot = parentSlot;
    //      this.previousBlockhash = previousBlockhash;
       
    // }

    //* poorpractice? should thnk about fixing this somewhre else or will need to deal w it. Optional types not used?
    @Json(name = "blockTime")
    private Object blockTime; // for null error?

    @Json(name = "blockhash")
    private String blockhash; 

    @Json(name = "parentSlot")
    private long parentSlot;

    @Json(name = "previousBlockhash")
    private String previousBlockhash;
    
    @Json(name = "rewards")
    private Reward[] rewards;

    @Json(name = "transactions")
    private Transaction[] transactions; 

    //present if signatures are requested for transaction details.
    @Json(name = "signatures")
    private List<String> signatures = null;



    public Object getBlockTime(){
        return blockTime;
    }
    public long getparentSlot(){
        return parentSlot;
    }
    public String getBlockhash(){
        return blockhash;
    }
    public Reward[] getRewards(){
        return rewards;
    }
    public Transaction[] getTransactions(){
        return transactions;
    }

    public List<String> getSignatures(){
        return signatures;
    }
    @Override
    public String toString() {
        return "Block{" +
                "blockTime=" + blockTime +
                ", blockHash='" + blockhash + '\'' +
                ", parentSlot='" + parentSlot + '\'' +
                ", previousBlockhash='" + previousBlockhash + '\'' +
                ", rewards='" + rewards + '\'' +
                ", transactions='" + transactions + '\'' +
                ", meta='" + meta + '\'' +
                '}';
    }
}
