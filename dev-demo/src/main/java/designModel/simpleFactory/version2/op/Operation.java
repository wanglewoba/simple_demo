package designModel.simpleFactory.version2.op;/**
 * Created by admin on 2017/11/27.
 */

/**
 * @author sunwenwu
 * @create 2017-11-27 15:51
 *
 * 封装一个简单抽象类计算类，提供基本的运算数据，一个抽象的结果方法，由子类具体实现
 **/
public abstract class Operation {
    public double fristNum;
    public double secondNum;

    public double getFristNum() {
        return fristNum;
    }

    public void setFristNum(double fristNum) {
        this.fristNum = fristNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    public abstract String getResult();
}
