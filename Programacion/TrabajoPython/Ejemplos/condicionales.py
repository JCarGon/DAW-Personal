temp = int(input("¿Qué temperatura hace? :"))
if(temp >= 0 and temp <= 15):
    print("Hace frío.")
elif(temp >= 16 and temp <= 30):
    print("Hace buen día.")
elif(temp > 30):
    print("Hace mucha calor.")
else:
    print("¡Me congelo!")