package basic_class_03;

import java.util.LinkedList;
import java.util.Queue;

public class Code_06_CatDog {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }

    public static class PetEnterQueue {
        private Pet pet;
        private int count;

        public PetEnterQueue(Pet pet, int count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return this.pet;
        }

        public long getCount() {
            return this.count;
        }

        public String getEnterPetType() {
            return this.pet.getPetType();
        }

    }

    public static class CatDogQueue {
        private Queue<PetEnterQueue> dogQueue;
        private Queue<PetEnterQueue> catQueue;
        private int count;

        public CatDogQueue() {
            dogQueue = new LinkedList<>();
            catQueue = new LinkedList<>();
            count = 0;
        }

        public void add(Pet pet) {
            if (pet.getPetType().equals("dog")) {
                this.dogQueue.add(new PetEnterQueue(pet, ++this.count));
            } else if (pet.getPetType().equals("cat")) {
                this.catQueue.add(new PetEnterQueue(pet, ++this.count));
            } else {
                throw new RuntimeException("err, not dog or cat");
            }
        }

        public Pet pollAll() {
            if (dogQueue.isEmpty() && catQueue.isEmpty()) {
                throw new IllegalArgumentException("queue is empty");
            }
            if (!dogQueue.isEmpty() && !catQueue.isEmpty()) {
                if (dogQueue.peek().count < catQueue.peek().count) {
                    return dogQueue.poll().getPet();
                } else {
                    return catQueue.poll().getPet();
                }
            } else if (!dogQueue.isEmpty()) {
                return dogQueue.poll().getPet();
            } else {
                return catQueue.poll().getPet();
            }

        }

        public Dog pollDog() {
            if (!this.isDogEmpty()) {
                return (Dog) dogQueue.poll().getPet();
            } else {
                throw new RuntimeException("Dog queue is empty!");
            }
        }

        public Cat pollCat() {
            if (!this.isCatEmpty()) {
                return (Cat) catQueue.poll().getPet();
            } else {
                throw new RuntimeException("Cat queue is empty!");
            }
        }

        public boolean isEmpty() {
            if (dogQueue.isEmpty() && catQueue.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isDogEmpty() {
            return dogQueue.isEmpty();
        }

        public boolean isCatEmpty() {
            return catQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        CatDogQueue test = new CatDogQueue();
        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
    }
}
