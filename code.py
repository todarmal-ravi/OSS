import threading
import time
import random

num_philosophers = 5
num_forks = num_philosophers
forks = [threading.Semaphore(1) for i in range(num_forks)]
mutex = threading.Semaphore(1)


def philosopher(index):
    while True:
        print(f"Philosopher {index} is thinking...")
        time.sleep(random.randint(1, 5))
        mutex.acquire()
        left_fork_index = index
        right_fork_index = (index + 1) % num_forks
        forks[left_fork_index].acquire()
        forks[right_fork_index].acquire()
        mutex.release()
        print(f"Philosopher {index} is eating...")
        time.sleep(random.randint(1, 5))
        forks[left_fork_index].release()
        forks[right_fork_index].release()


philosopher_threads = []
for i in range(num_philosophers):
    philosopher_threads.append(threading.Thread(target=philosopher, args=(i,)))
for thread in philosopher_threads:
    thread.start()
for thread in philosopher_threads:
    thread.join()
