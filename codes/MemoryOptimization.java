// Enum often require more than twice as much memory as static constants. You should avoid using enums on Android.

// DEX file size 2680
private static final int VALUE1 = 1;
private static final int VALUE2 = 2;
private static final int VALUE3 = 3;
int function(Value value) {
    switch(value) {
        case VALUE1:
            return -1;
        case VALUE2:
            return -1;
        case VALUE3:
            return -1;
        }
        return 0;
     }


// DEX file size 4188 Bytes --> Bloats your DEX File, eat your heap space.
public static enum Value {
    VALUE1, VALUE2, VALUE3
}
    int function(Value value) {
        switch (value) {
            case VALUE1:
                return -1;
            case VALUE2:
                return -1;
            case VALUE3:
                return -1;
        }
        return 0;
    }


// Otherwise you can use @IntDef annotation for built time safety.
@Retention(CLASS)
@IntDef({VALUE1, VALUE2, VALUE3})
public @interface ExampleMode {
}
    public static final int VALUE1 = 0;
    public static final int VALUE2 = 1;
    public static final int VALUE3 = 2;
...

public abstract void setExampleMode(@ExampleMode int mode)
@ExampleMode
public abstract int getExampleMode();
