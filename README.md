# ArrayListHelper (Experimental)
This library aims to help developers update `RecyclerView` with correct animations when there are changes to the respective `ArrayList`. It makes use of `RecyclerView.Adapter` built-in functions `notifyItemInserted` and `notifyItemRemoved` to update respective items in the RecyclerView.
## Usage
In order to use this library in Android Studio, add the following code in your project's gradle file. Dependency for `RecyclerView` in Android Support Library is also needed.
```gradle
dependencies {
	...
	compile 'com.android.support:recyclerview-v7:+'
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
    myHelper = new ArrayListHelper<>(adapter, sourceArrayList);
    ...
}
```
### Update RecyclerView
#### Method 1
You should use this method when you have a new `ArrayList` to replace the old list.<br/>With this method, you **DO NOT** need to change the original `ArrayList` after you have set it as the _source_ for the helper.

Each time you want to update the `RecyclerView` with a new `ArrayList`, pass the new list into `updateDataSource` of the helper.
```java
myHelper.updateDataSource(newSourceArrayList);
```
The helper will replace the contents of the old list with the new list, while updating the `RecyclerView`.
#### Method 2
// TODO