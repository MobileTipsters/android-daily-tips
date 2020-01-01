// Step 1: Add deep link element inside fragment of navigation graph
<deepLink app:uri="test://fetch/account" />

// Step 2: To enable implicit deep linking, Add a single <nav-graph> element to an activity that points to an existing navigation graph
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.myapplication">

    <application ... >

        <activity name=".MainActivity" ...>
            ...

            <nav-graph android:value="@navigation/nav_graph" />

            ...

        </activity>
    </application>
</manifest>


// Step 3 (Optional): Also you can handle parameters of deep link with placeholder
test://fetch/account?displayName={display_name}

// Step 4: To read data from placeholder, you need add an argument below deep link element 
<argument android:name="display_name" app:argType="string"/>

// Step 5: Now you can use deep link placeholder's data in fragment with arguments
val displayName = arguments?.get("display_name") as String