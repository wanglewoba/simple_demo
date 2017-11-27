package designModel.simpleFactory.version2.op;/**
 * Created by admin on 2017/11/27.
 */

/**
 * @author sunwenwu
 * @create 2017-11-27 15:57
 **/
public class OpertationSum extends Operation{
    @Override
    public String getResult() {
        return String.valueOf(fristNum + secondNum);
    }
}
