import os

def get_file_paths(directory):
    file_paths = []
    for root, directories, files in os.walk(directory):
        for filename in files:
            filepath = os.path.join(root, filename)
            file_paths.append(filepath)
    return file_paths

def get_file_paths_with_extension(root, extensions):
    file_paths = []
    for subdir, dirs, files in os.walk(root):
        for file in files:
            if file.endswith(tuple(extensions)):
                file_path = os.path.join(subdir, file)
                file_paths.append(file_path)
    return file_paths

def read_files(file_paths):
    file_contents = []
    for file_path in file_paths:
        file_contents.append(f"Filepath: {file_path} \n```")
        with open(file_path, 'r') as f:
            file_contents.append(f.read())
        file_contents.append("\n ```")
    return file_contents

####      MAIN      ####          
                 
directory = '/home/stian/Code/svinn'

#with open(directory + '/ShortDesc.md', 'r') as f:
#            print(f.read())

extentions = ['.java','.properties', '.sql']
filePaths = get_file_paths_with_extension(directory, extentions)

print(f"# This is some relevant files from my repo:")

for i in filePaths:
    print(i)

fileContents = read_files(filePaths)

for i in fileContents:
    print(i)