package designModel.simpleFactory.version2.factory;/**
 * Created by admin on 2017/11/27.
 */

import designModel.simpleFactory.version2.op.Operation;
import designModel.simpleFactory.version2.op.OpertationMul;
import designModel.simpleFactory.version2.op.OpertationSub;
import designModel.simpleFactory.version2.op.OpertationSum;

/**
 * @author sunwenwu
 * @create 2017-11-27 16:04
 **/
public class OpFactory {
    public static Operation getOp(String op){
        Operation ops = null;
        if("+".equals(op)){
            ops = new OpertationSum();
        }else if("-".equals(op)){
            ops = new OpertationSub();
        }else if("*".equals(op)){
            ops = new OpertationMul();
        }
        return ops;
    }
}
