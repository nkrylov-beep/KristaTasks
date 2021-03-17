package org.example;

import java.lang.reflect.Field;

public class Checker {
    static public boolean isEquals(Object obj1, Object obj2) {
        if (obj1 == null || obj1.getClass() != obj2.getClass()) return false;
        else {
            Field[] obj1Fields = obj1.getClass().getDeclaredFields();
            Field[] obj2Fields = obj2.getClass().getDeclaredFields();
            if (obj1Fields.length == obj2Fields.length && obj1Fields.length == 0) return true;
            try {
                for (int i = 0; i < obj1Fields.length; ++i) {
                    Field obj1Field = obj1Fields[i];
                    Field obj2Field = obj2Fields[i];
                    obj1Field.setAccessible(true);
                    obj2Field.setAccessible(true);
                    Object obj1FieldValue = obj1Field.get(obj1);
                    Object obj2FieldValue = obj2Field.get(obj2);
                    if (obj1FieldValue == null || obj2FieldValue == null) {
                        if (!(obj1FieldValue == null && obj2FieldValue == null)) return false;
                    } else if (!obj1Field.get(obj1).equals(obj2Field.get(obj2))) return false;
                }
            } catch (IllegalAccessException e) {
                System.err.println(e);
            }
            return true;
        }
    }
}
