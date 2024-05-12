class Studentsdatabase
{
    static void Main(string[] args)
    {
        Console.WriteLine("Please enter number of new students to enroll: ");
        int numOfStudents = 0;
        Student[] students = new Student[0];
        bool temp = true;
        while (temp == true)
        {
            try
            {
                numOfStudents = Int32.Parse(Console.ReadLine());
                if (numOfStudents < 1)
                {
                    while (numOfStudents < 1)
                    {
                        Console.WriteLine("Please enter positive number: ");
                        numOfStudents = Int32.Parse(Console.ReadLine());
                    }
                }
                students = new Student[numOfStudents];
                temp = false;
            }
            catch (Exception e)
            {
                Console.WriteLine("Please enter a number: ");
            }    
        }
        for (int i = 0; i <= numOfStudents-1; i++)
        {
            students[i] = new Student();
            students[i].enroll();
            students[i].coursesPayment();
           Console.WriteLine(students[i].showInfo());
        }
    }
}