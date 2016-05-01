c++11新标准中引入了四个头文件来支持多线程编程；分别是<atomic><thread><mutex>
<condition_variable><future>
<aomic>该头文件主要声明了两个类，std:aotmic和std:atomic_flag，另外还还声明了一套c风格的原子类型和c兼容的原子操作函数
<thread>该头文件主要声明了std:thread类，另外std:this_thread命名空间也在该头文件中。
<mutex>该头文件主要声明了与互斥量(mutex)相关的类，包括std:mutex系列类，std::lock_guard,std::unique_lock,以及其他的类型和函数
<condition_variable>:该头文件主要声明了与条件变量相关的类，包括std:condition_variable和std::condition_variable_any
<future>该头文件主要声明了std::promise,std::package_task两个provider类,std:async()函数就声明在此头文件中。

eg:
#include<stdio.h>
#include<stdlib.h>
#include<thread>	//std::thread
#include<iostream>	//std::cout
using namespace std;
void thread_task(){
	cout<<"hello thread"<<endl;
}

int main(int argc,const char*argv[])
{
	thread t(thread_task);
	t.join();
	return EXIT_SUCCESS;
}







	


