//
//  AddNotificationView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/23/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct AddNotificationView: View {
    @State private var assignmentName = ""
    @State private var dueDate = Date()
    
    var body: some View {
        VStack {
            //Assignment Name and Due Date
            
            TextField("Assignment Name", text: $assignmentName)
                .padding()
            
            DatePicker("Due Date", selection: $dueDate, displayedComponents: .date)
                .padding()
            
            //Add Notification Button
            Button(action: {
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
    }
}


