public class PyramidSorting {
    // рекурсивный алгоритм. Узел с индексом `item` и 2 его прямых потомка нарушают свойство кучи
    public static void heapify(int massiv[], int item, int size){
        // получить левый и правый потомки узла
        int left = item*2 +1;
        int read = item*2 +2;
        int root = item;
        //сравниваем massiv[root] с его левым и правым дочерними элементами и находим наибольшее значение, присваиваем его root
        if (left < size && massiv[root] < massiv[left]){root = left;}
        if (read < size && massiv[root] < massiv[read]){root = read;}
        //поменяться местами с потомком, имеющим большее значение и вызываем рекурсию для дочернего элемента
        if (root != item){
            int temp = massiv[root];
            massiv[root] = massiv[item];
            massiv[item] = temp;
            heapify(massiv, root, size);
        }
    }
    //функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] massiv, int size){
        //если в куче нет элементов
        if (size <= 0){
            return -1;
        }
        //заменяем корень кучи последним элементом массива
        int root = massiv[0];
        massiv[0] = massiv[size-1];
        //вызовите heapify на корневом узле
        heapify(massiv, 0, size-1);
        return root;
    }

    //функция для выполнения пирамидальной сортировки массива
    public static void heapSort(int[] massiv) {
        //строим приоритетную очередь и инициализируем ее заданным массивом
        int n = massiv.length;
        //build-heap: вызывать heapify, начиная с последнего внутреннего
        //узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(massiv, i--, n);
        }
        //несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            massiv[n - 1] = pop(massiv, n);
            n--;
        }
    }
    public static void main(String args[]) {
        int[] sortArr = {1, 2, 3, 4, 5, 6, 25, 5, 5, 15, 7, 99, 100, 23};
        heapSort(sortArr);
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + "\n");
        }
    }


}
