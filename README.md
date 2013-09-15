# Story Point Estimator for Android

Agile (software) projects use *user stories* to define tasks that have to be
done in the project. User stories often have a certain *story point* value
that indicates the size of the task. However, giving a point estimate for a
user story is a difficult task.

This Android app will help in that by giving an accurate story point estimate
for each user story.


## How to compile and run

Make sure you have [lein droid](https://github.com/clojure-android/lein-droid)
installed.

Also, make sure you have an Android emulator running. Then you can just enter
the following command to build the project and install it to the emulator:

```bash
lein droid doall
```

For more instructions, see lein droid
[tutorial](https://github.com/clojure-android/lein-droid/wiki/Tutorial).

**NOTE: Do not try to use JDK7 -- it doesn't work with lein droid. Use JDK6**
