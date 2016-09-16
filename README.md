# ArrayListHelper (Experimental)
This library aims to help developers update `RecyclerView` with correct animations when there are changes to the respective `ArrayList`. It makes use of `RecyclerView.Adapter` built-in functions `notifyItemInserted` and `notifyItemRemoved` to update respective items in the RecyclerView.
## Usage
In order to use this library in Android Studio, add the following code in your project's gradle file.
```gradle
dependencies {
	...
	compile 'hk.sheryiu.arraylisthelper:arraylisthelper:1.0-beta-3'
	...
}
```
Then create a new instance of `ArrayListHelper` as a class variable in the class where you have your `RecyclerView`. Your instance should have the same type parameter as your `ArrayList`.

You should initialize the instance in your `onCreate` method.
```java
private ArrayListHelper<String> myHelper;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    myHelper = new ArrayListHelper<>(adapter, source);
    ...
}
```