package org.thappo.commons.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MethodScanner {
	
	//private Method method;
    private List<Argument> arguments;


    public MethodScanner(Method method, Object[] arguments) {
        this.scan(method, arguments);
    }

    private void scan(Method method, Object[] arguments) {
        this.arguments = new ArrayList<MethodScanner.Argument>();
        int i = 0;
        for (Annotation[] annotations : method.getParameterAnnotations()) {
            Argument argument = new Argument();
            argument.setObject(arguments[i++]);
            argument.setAnnotations(annotations);
            this.arguments.add(argument);
        }
    }

    public <T> List<Argument> getArgumentsAnnotatedWith(Class<T> constraint) {
        List<Argument> result = new ArrayList<Argument>();
        for (Argument argument : this.arguments) {
            for (Annotation annotation : argument.getAnnotations()) {
                if (constraint.isInstance(annotation)) {
                    result.add(argument);
                }
            }
        }
        return result;
    }

    public class Argument {

        private Object object;
        private Annotation[] annotations;

        public Object getObject() {
            return this.object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public Annotation[] getAnnotations() {
            return this.annotations;
        }

        public <T> Annotation getAnnotation(Class<T> constraint) {
            Annotation result = null;
            for (Annotation annotation : this.annotations) {
                if (constraint.isInstance(annotation)) {
                    result = annotation;
                }
            }
            return result;
        }

        public void setAnnotations(Annotation[] annotations) {
            this.annotations = annotations;
        }

    }

}
