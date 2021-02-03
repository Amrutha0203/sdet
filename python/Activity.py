#Class of Cars
class car:
    'This is a car activity'

    def __init__(self, manufacturer, model, make, transmission, color):
                self.manufacturer= manufacturer
                self.model = model
                self.make = make
                self.transmission= transmission
                self.color= color

    def accelerate(self):
                    print(self.manufacturer +" "+ self.model + " is moving")

    def stop(self):
                    print(self.manufacturer +" "+ self.model + " has stopped")

car1= car("Honda", "Activa", 2018, "Manual","Navy Blue")
car2= car("Toyota", "Corolla", 2015, "Automatic","Red")
car3= car("Maruti", "800", 2018, "Manual", "White")

car1.accelerate()
car1.stop()
car2.accelerate()
car2.stop()
car3.accelerate()
car3.stop()