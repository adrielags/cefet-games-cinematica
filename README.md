# Kinematic movement

![](docs/preview.png)

Project objectives:
  See the movement of agents as an algorithm
  Practice simple movement algorithms using kinematics

The moviments implemented to the particles are as following:

1. **(_seek_)**
2. **(_flee_)**
2. **(_wander_)**
4. **(_arrive_)**

## Result

![](docs/resultado-final.gif)

The algorithms that we will implement:

1. ** Search **: agent receives an objective position
   - Calculate the desired direction
     - Consider the position of the objective and the position of the agent
   - Normalize the direction, but multiply it by the maximum speed
2. ** Escape **: opposite direction of the search
3. ** Go **:
   - Agent always at maximum tangential speed
   - Direction undergoes random variations with each frame
4. ** Arrive **: search variation
   - Determine a small "satisfaction radius"
   - Stop as soon as you reach the radius



## FAQ

1. What are the controls?
   - LEFT button: creates a new agent in the clicked position, with the algorithm
     current handling
   - RIGHT button: defines where / who is the target
   - Wheel: zoom
1. How do I define who the current algorithm is?
   - Each ʻAlgoritmoMovimentacao` has a name (one letter only) and one
     key that makes it the current algorithm. Just press it. They are:
     - `s`: (_seek_)
     - `w`: (_wander_)
     - `f`: (_flee_)
1. Where is the 'Arriving' class?
   - It does not exist and you must create it.
   - In the `Cinematica.java` class (the main one), in the` create () `method, you
     must instantiate, configure and register an object of type `Arriving`
     to be able to use this new algorithm.


