package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        User u = new User();
        User[] uu = {};
        u.setU(uu);
        checkObjectNotNull(u);
    }

    public static void checkObjectNotNull(Object object) throws Exception {
        Method[] m = object.getClass().getDeclaredMethods();

        for (int i = 0; i < m.length; i++) {
            Method method = m[i];
            System.out.println(m[i].getName());

            Annotation[] annotations = method.getDeclaredAnnotations();
            for (int j = 0; j < annotations.length; j++) {
                Annotation annotation = annotations[j];
                if (annotation.annotationType() == NotEmpty.class) {
                    Object result = method.invoke(object);
                    if (result == null) {
                        throw new IllegalArgumentException("It cannot be null");
                    }
                    if (result instanceof Object[]) {
                        Object[] arr = (Object[]) result;
                        if (arr.length == 0) {
                            throw new IllegalArgumentException("The array cannot be empty");
                        }
                    }
                }
                System.out.println(annotation);
            }
            System.out.println("=======================");
        }
    }
}
