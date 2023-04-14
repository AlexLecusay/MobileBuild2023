//
//  ClassCreation.swift
//  RoaryMinder
//
//  Created by Camila on 3/24/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ClassCreationView: View {
    @State private var courseName = ""
    @State private var courseDescription = ""
    @ObservedObject var viewModel: iOSRoaryViewModel
    @Environment(\.presentationMode) var presentationMode

    var body: some View {
        VStack {
            //Course & Professor Name
            
            TextField("Course Name", text: $courseName)
                .padding()
            TextField("courseDescription", text: $courseDescription)
                .padding()
            
            //Add Class Button
            Button(action: {
                let newClass = RoaryRepoInfo()
                let assignments = Assignments()
                let chatRepo = ChatRepos()
                newClass.className = courseName
                newClass.classDescription = courseDescription
                assignments.assignmentName = "Assignment 1"
                assignments.assignmentDescription = ""
                assignments.chatRepo = chatRepo
                newClass.classAssignments.add(assignments)
                viewModel.getRepo().saveQuery(classForRepo: newClass)
                self.presentationMode.wrappedValue.dismiss()
            }) {
                Text("Add Class")
                    .foregroundColor(.white)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color.blue)
                    .cornerRadius(10)
            }
            .padding()
            
            
        }
        .padding()
        .navigationBarTitle("Class Creation")
    }
    
    
}
