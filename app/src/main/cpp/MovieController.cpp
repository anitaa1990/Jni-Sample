#include <jni.h>
#include "MovieController.hpp"

static jclass java_util_ArrayList;
static jmethodID java_util_ArrayList_;
jmethodID java_util_ArrayList_add;
jmethodID java_util_ArrayList_size;
jmethodID java_util_ArrayList_get;

void initArrayList(JNIEnv *env) {
    java_util_ArrayList = static_cast<jclass>(env->NewGlobalRef(
            env->FindClass("java/util/ArrayList")));
    java_util_ArrayList_ = env->GetMethodID(java_util_ArrayList, "<init>", "(I)V");
    java_util_ArrayList_size = env->GetMethodID(java_util_ArrayList, "size", "()I");
    java_util_ArrayList_get = env->GetMethodID(java_util_ArrayList, "get", "(I)Ljava/lang/Object;");
    java_util_ArrayList_add = env->GetMethodID(java_util_ArrayList, "add", "(Ljava/lang/Object;)Z");
}

jobject getMovieListFromVector(JNIEnv *env,
                               std::vector<movies::Movie *> results) {

    jobject result = env->NewObject(java_util_ArrayList, java_util_ArrayList_, results.size());

    for (int i = 0; i < results.size(); i++) {
        movies::Movie *movie = results[i];

        jclass movieClass = env->FindClass("com/an/moviesample/model/Movie");
        jobject newMovieData = env->AllocObject(movieClass);

        jfieldID nameField = env->GetFieldID(movieClass, "name", "Ljava/lang/String;");
        jfieldID descriptionField = env->GetFieldID(movieClass, "description", "Ljava/lang/String;");
        jfieldID posterUrlField = env->GetFieldID(movieClass, "posterUrl", "Ljava/lang/String;");
        jfieldID videosField = env->GetFieldID(movieClass, "videos", "Ljava/lang/String;");
        jfieldID releaseDateField = env->GetFieldID(movieClass, "releaseDate", "Ljava/lang/String;");
        jfieldID statusField = env->GetFieldID(movieClass, "status", "Ljava/lang/String;");
        jfieldID genresField = env->GetFieldID(movieClass, "genres", "Ljava/lang/String;");
        jfieldID runtimeField = env->GetFieldID(movieClass, "runtime", "J");

        env->SetObjectField(newMovieData, nameField, env->NewStringUTF(movie->name.c_str()));
        env->SetObjectField(newMovieData, posterUrlField, env->NewStringUTF(movie->posterUrl.c_str()));
        env->SetObjectField(newMovieData, descriptionField, env->NewStringUTF(movie->description.c_str()));
        env->SetObjectField(newMovieData, videosField, env->NewStringUTF(movie->videos.c_str()));
        env->SetObjectField(newMovieData, releaseDateField, env->NewStringUTF(movie->releaseDate.c_str()));
        env->SetObjectField(newMovieData, statusField, env->NewStringUTF(movie->status.c_str()));
        env->SetObjectField(newMovieData, genresField, env->NewStringUTF(movie->genres.c_str()));
        env->SetLongField(newMovieData, runtimeField, movie->runtime);


        env->CallBooleanMethod(result, java_util_ArrayList_add, newMovieData);
        env->DeleteLocalRef(newMovieData);
    }
    return result;
}


extern "C" JNIEXPORT jobject JNICALL
Java_com_an_moviesample_activity_MainActivity_getMovies(
        JNIEnv *env,
        jobject /* this */) {

    movies::MovieController movieController = movies::MovieController();
    std::vector<movies::Movie *> results = movieController.getMovies();

    initArrayList(env);
    return getMovieListFromVector(env, results);
}

