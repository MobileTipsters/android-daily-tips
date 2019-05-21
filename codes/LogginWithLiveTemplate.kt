//Logging methods and parameters with Timber via Live Template 
Abbreviation:
timberm

Context:
Kotlin: statement

Template text:
timber.log.Timber.d($CONTENT$)

Variables:
CONTENT

Expression: 
groovyScript("def params = _2.collect {it + ' = [\$' + it + ']'}.join(', ');return '\"' + _1 + '() called' + (params.empty  ? '' : ' with: ' + params) + '\"'", kotlinFunctionName(), functionParameters())
  
//timberm  
fun foo(bar1: Int, bar2: String) {
	Timber.d("foo() called with: bar1 = [$bar1], bar2 = [$bar2]")
}