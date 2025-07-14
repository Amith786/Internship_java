import time  # Importing the time module for adding delays

print("Please insert your CARD")  
time.sleep(3)  # Simulating the time delay for card processing

# Setting the default ATM PIN and initial balance
atm_pin = 1234  
pin = int(input("Enter your ATM PIN:"))  # Asking user to enter the PIN
balance = 4000  # Initial balance set to ₹4000

# Checking if the entered PIN is correct
if pin == atm_pin:
    while True:  # Infinite loop to keep the ATM menu running until user exits
        print("\n ATM Menu:")
        print("""
            1 == Balance Inquiry
            2 == Withdraw
            3 == Deposit 
            4 == Change Pin
            5 == Exit
        """)

        # Handling invalid input (if the user enters non-numeric input)
        try:
            option = int(input("Please Enter your Choice:"))  
        except ValueError:
            print("Please Enter Valid Option")  # Prompting the user to enter a valid choice
            continue  # Restarting the loop if an invalid input is entered

        # Option 1: Display account balance
        if option == 1:
            print(f"Your current balance is: ₹{balance}")

        # Option 2: Withdraw money
        elif option == 2:
            withdraw_amount = int(input("Please enter withdraw amount:"))
            if withdraw_amount > balance:  # Checking if the balance is sufficient
                print("Insufficient balance!")  
            else:
                balance -= withdraw_amount  # Deducting the withdrawal amount
                print(f"{withdraw_amount} is debited from your account")
                print(f"Your current balance is: ₹{balance}")

        # Option 3: Deposit money
        elif option == 3:
            deposit_amount = int(input("Please enter deposit amount:"))
            balance += deposit_amount  # Adding the deposit amount to balance
            print(f"{deposit_amount} is credited to your account")
            print(f"Your current balance is: ₹{balance}")

        # Option 4: Change ATM PIN
        elif option == 4:
            new_pin = int(input("Enter new PIN:"))
            confirm_pin = int(input("Confirm new PIN:"))
            if new_pin == confirm_pin:  # Checking if both entered PINs match
                atm_pin = new_pin  # Updating the PIN
                print("PIN changed successfully")
            else:
                print("PIN doesn't match. Try again")

        # Option 5: Exit the ATM
        elif option == 5:
            print("Thank you for using our ATM. Have a great day!")
            break  # Exiting the loop

else:
    print("Pin is INVALID!!! \nPlease try Again...")  # Invalid PIN message
