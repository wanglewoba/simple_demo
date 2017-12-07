package common.util;

import common.bean.Man;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Set;

/**
 * @Description: jsr 203 校验帮助类
 */
public final class BOValidator {


    private BOValidator() {
    }

    public static <T> String validate(T obj) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraintViolations = factory.getValidator().validate(obj);

        for (ConstraintViolation constraintViolation : constraintViolations) {
            return constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage();
        }
        return null;
    }


    /**
     * 过滤对象所有字符串属性的前后空格
     *
     * @param clazz
     * @param t
     * @throws Exception
     * @author donglei
     * @since 2016-05-09
     */
    public static <T> void trimProperty(Class<T> clazz, T t) throws Exception {

        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String retValue = null;
            if (descriptor.getPropertyType().getName().equals("java.lang.String")) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = descriptor.getReadMethod().invoke(t, null);
                if (value == null || StringUtils.isBlank(value.toString())) {
                    retValue = "";
                } else {
                    retValue = value.toString().trim();
                }
                Object[] args = new Object[1];
                args[0] = retValue;
                descriptor.getWriteMethod().invoke(t, args);

            }
        }

    }

    public static void main(String[] args) {
        /**
         * 测试结果：
         * tradeDate:交易日期不能有特殊字符
         */
        Man m = new Man();
        m.setAge("11");
        m.setName("aaa");
        m.setTradeDate("20013000)");
        String validate = BOValidator.validate(m);
        System.out.println(validate);
    }
}
