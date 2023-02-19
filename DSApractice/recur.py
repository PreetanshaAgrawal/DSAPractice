# def fun(a):
#     if(a > 10): return
#     a += 1
#     print(a)
#     fun(a)


# Reverse of the string
# try to use one pointer

# def revStr(s):

#     if(len(s) == 0): return s;

#     temp = s[0]
#     # print(temp)
#     revStr(s[1:])
#     print(temp, end='')


# s = "abcde"

# one line to reverse a string in python
# s = s[::-1]
# print(s)

# print(revStr(s))


# check the palindrome

# def check(s, i, j):
#     if(s[i] != s[j] and i < j): return False
#     if(i>j): return True

#     return check(s, i+1, j-1)


# s="abcde"
# i=0
# j = len(s)-1
# print(check(s,i,j))


# calculate power using Recursion

# def powerOfNumber(a,b):
#     if(b == 0): return 1;
#     if(b == 1): return a;

#     ans = powerOfNumber(a, b//2);

#     if(b %2 != 1):
#         return ans*ans
#     else:
#         return a * ans* ans


# p = powerOfNumber(3, 10)
# print(p)


# if __name__ == '__main__':
#     fun(1)


# bubble sort

# def bubbleSort(arr, n):
#     if(n == 0 or n == 1): return;

#     for i in range(n-1):
#         if(arr[i] > arr[i+1]):
#             arr[i], arr[i+1] = arr[i+1], arr[i]


#     bubbleSort(arr, n-1)

# arr = [3,2,4,1,5]
# n = len(arr)
# bubbleSort(arr, n)
# print(arr)


# homework = selection and insertion sort

# selection sort

# def selection(arr, n):
#     for i in range(n):
#         min_idx = i;
#         for j in range(i+1, n):
#             if(arr[j] < arr[min_idx]):
#                 min_idx = j
#         arr[i], arr[min_idx] = arr[min_idx], arr[i]


# arr = [64, 23, 12, 67, 18, 11]

# selection(arr, len(arr))
# print(arr)


# # selection sort using recursion
# def selection(arr,i, n):

#     if(i >= n): return

#     min_idx = i;
#     for j in range(i+1, n):
#         if(arr[j] < arr[min_idx]):
#             min_idx = j
#     arr[i], arr[min_idx] = arr[min_idx], arr[i]

#     selection(arr, i+1, n)

# arr = [64, 23, 12, 67, 18, 11]

# selection(arr, 0, len(arr))
# print(arr)


# Insertion sort

# def insertionSort(arr, n):
#     if(n<=1): return


#     # sort first n-1 elements
#     insertionSort(arr, n-1)
#     print(arr)
#     # insert last element at its right position
#     last = arr[n-1]
#     j = n-2

#     while(j>=0 and arr[j] > last):
#         arr[j+1] = arr[j]
#         j-=1

#     arr[j+1] = last

# arr = [12, 11, 13, 5,6]
# insertionSort(arr, len(arr));
# print(arr)


# SubSets or PowerSets of numbers

# def subset(arr, n):


# inversion count using merge sort


def mergeS(arr, temp, s, e):
    cnt = 0
    if s < e:
        mid = (s + e) // 2

        cnt += mergeS(arr, temp, s, mid)
        cnt += mergeS(arr, temp, mid + 1, e)

        cnt += merge(arr, temp, s, mid, e)
    return cnt


def merge(arr, temp, s, mid, e):
    cnt = 0

    # first = arr[: mid]
    # second = arr[mid :]

    i = s
    j = mid + 1
    k = s
    while i <= mid and j <= e:
        if arr[i] > arr[j]:
            temp[k] = arr[j]
            j += 1
            k += 1
            cnt += mid - i + 1
        else:
            temp[k] = arr[i]
            i += 1
            k += 1

    while i <= mid:
        temp[k] = arr[i]
        k += 1
        i += 1
    while j <= e:
        temp[k] = arr[j]
        k += 1
        j += 1

    for i in range(s, e + 1):
        arr[i] = temp[i]
    return cnt


arr = [1, 20, 6, 4, 5]
e = len(arr)
temp = [0] * e
cnt = mergeS(arr, temp, 0, e - 1)
print(cnt)
print(arr)
