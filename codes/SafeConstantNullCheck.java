private static final String CONSTANT_STRING = "constant_string";

// NPE PRONE
if(responseTitle.equals(CONSTANT_STRING)){

}

// RIGHT WAY
if (CONSTANT_STRING.equals(responseTitle)){

}