package Main;


public class Game implements Runnable {

    Boolean isRunning = true;
    private Thread thread;

    public void tick(){}

    public void render(){}

    public Game(){
        Frame frame = new Frame();
        frame.newFrame();
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        double timer = System.currentTimeMillis();
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                render();
                frames++;
                delta--;
            }
            if (System.currentTimeMillis() - timer >= 1000) {
                System.out.println("FPS:" + frames);
                frames = 0;
                timer += 1000;
            }
        }
        Stop();
    }

    /**
     * Inicia a Thread principal
     * */
    public synchronized void Start() {
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void Stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
