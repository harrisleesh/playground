package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    /*
    mplement a FIFO queue with limited size. It should support the following commands:

SIZE
OFFER x
TAKE
x can be any string.

⚠️ Please describe algorithm complexity as comment.

Input
N C
command 1
command 2...
Where N is the number of commands (1 <= N <= 10000) and C the capacity of the queue (0 <= C <= 10000).

Output
For SIZE command, the number of items currently in the queue followed by a newline.
For TAKE command, the item taken followed by a newline if the queue was not empty. Nothing otherwise.
For OFFER command, "true" if the item was accepted by the queue, or "false" otherwise, followed by a newline.
Input example
5 2
OFFER hello
OFFER world
OFFER !
TAKE
SIZE
Output example
For the above input,

true
true
false
hello
1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] requirements = input.split(" ");
        if (requirements.length != 2) {
            System.out.println("requirements need only numberOfCommands and capacityOfQueue");
        }
        int numberOfCommands = Integer.parseInt(requirements[0]);
        int capacityOfQueue = Integer.parseInt(requirements[1]);

        Queue queue = new Queue(capacityOfQueue);
        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = br.readLine().split(" ");
            String result = "";
            if (command[0].equals("OFFER")) {
                result = queue.offer(command[1]);
            } else if (command[0].equals("TAKE")) {
                result = queue.take();
            } else if (command[0].equals("SIZE")) {
                result = queue.size();
            }
            System.out.println(result);
        }

    }

    static class Queue{
        private List<String> queue = new ArrayList<>();
        private int capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
        }

        public String offer(String item) {
            if (queue.size() >= capacity) {
                return "false";
            }
            queue.add(item);
            return "true";
        }

        public String take() {
            if (queue.isEmpty()) {
                return "";
            }
            return queue.remove(0);
        }

        public String size() {
            return String.valueOf(queue.size());
        }
    }
}
