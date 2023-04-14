//
//  AddNotificationView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/23/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AddNotificationView: View {
    @Binding var assignments: [Assignments]
    @State private var assignmentName = ""
    @State private var dueDate = Date()
    @State private var assignmentDescription = ""
    @State private var showAlert = false
    @State var course: RoaryRepoInfo
    @ObservedObject var viewModel: iOSRoaryViewModel

    @Environment(\.presentationMode) var presentationMode // <-- Add this line
    
    var body: some View {
        VStack {
            // Assignment Name, Description, and Due Date
            TextField("Assignment Name", text: $assignmentName)
                .padding()

            TextField("Assignment Description", text: $assignmentDescription)
                .padding()

            DatePicker("Due Date", selection: $dueDate, displayedComponents: .date)
                .padding()

            // Add Notification Button
            Button(action: {
                if assignmentName.isEmpty || assignmentDescription.isEmpty {
                    showAlert = true
                } else {
                    addAssignment(assignmentName: assignmentName, assignmentDescription: assignmentDescription,course: course,viewModel: viewModel.getRepo())
                    presentationMode.wrappedValue.dismiss() // <-- Add this line
                }
            }) {
                Text("Add Notification")
                    .foregroundColor(.white)
                    .padding()
                    .frame(maxWidth: .infinity)
                    .background(Color.blue)
                    .cornerRadius(10)
            }
            .padding()
        }
        .padding()
        .navigationBarTitle("Notification Creation")
        .alert(isPresented: $showAlert) {
            Alert(
                title: Text("Incomplete Fields"),
                message: Text("Please fill out both the Assignment Name and Description fields."),
                dismissButton: .default(Text("OK"))
            )
        }
    }
}



