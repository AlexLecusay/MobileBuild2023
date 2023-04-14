//
//  NotificationView.swift
//  RoaryMinder
//
//  Created by Zacharias Lafond on 3/7/23.
//  Copyright © 2023 orgName. All rights reserved.
//


import SwiftUI
import shared

struct NotificationView: View {
    var assignment: Assignments
    @State var isBellFilled = false
    var bellAction: () -> Void
    
    var body: some View {
        ZStack {
            VStack(alignment: .leading, spacing: 10) {
                Text(assignment.assignmentName)
                    .font(.subheadline)
                    .bold()
                    .foregroundColor(.primary)
               
                Text(formattedDate(Date()))
                    .font(.subheadline)
                    .foregroundColor(.secondary)
                
                Text(assignment.assignmentDescription)
                    .font(.subheadline)
                    .foregroundColor(.primary)
                
                Spacer()
            }
            .padding()
            
            HStack {
                Spacer()
                Button(action: {
                    isBellFilled.toggle()
                    bellAction()
                }) {
                    Image(systemName: isBellFilled ? "bell.fill" : "bell")
                        .foregroundColor(isBellFilled ? .red : .blue)
                        .padding(.trailing)
                        .padding(.top)
                }
                
                Button(action: {}) {
                    Image(systemName: "trash")
                        .foregroundColor(.red)
                        .padding(.trailing)
                        .padding(.top)
                }
            }
        }
        .background(Color(UIColor.systemBackground))
        .cornerRadius(10)
        .shadow(color: Color.gray.opacity(0.1), radius: 1, x: 0, y: 1)
    }
    
    private func formattedDate(_ date: Date) -> String {
        let formatter = DateFormatter()
        formatter.dateFormat = "MM/dd/yyyy hh:mma"
        return formatter.string(from: date)
    }
}

struct NotificationView_Previews: PreviewProvider {
    static var previews: some View {
        let testAssigment = Assignments()
        
        NotificationView(assignment: testAssigment, bellAction: {})
    }
}

