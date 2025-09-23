def get_course_name():
    """ allow user to enter course name """
    course_name = input("Enter the name of the course ")
    return course_name

def get_project_name(course_name, next_project_number):
    """ get project name from user """
    print ("For the course '%s',\n    enter the name of project %d"
           % (course_name, next_project_number))
    return input("Or hit enter to finish ")

def get_grade(project_num, current_project):
    """ get grade for given project """
    return input("Enter the grade for\n    project %d (%s)"
                 % (project_num, current_project))

def show_percentage(grades):
    """ prints average grades """
    sum = 0
    for grade in grades:
        sum += int(grade)

    print ("Average grade is %5.2f" % (float(sum) / len(grades)))

#----main----------------------

def main():
    next_project_number = 1
    projects = []

    course_name = get_course_name()
    project_name = get_project_name(course_name, next_project_number)
    while project_name != '':
        projects.append(project_name)
        next_project_number += 1
        project_name = get_project_name(course_name, next_project_number)

    print(projects)

    current_project = ''
    grades = []

    for index in range(len(projects)):
        project_num = index + 1
        current_project = projects[index]
        grades.append(get_grade(project_num, current_project))

    show_percentage(grades)

if __name__ == "__main__":
    main()
