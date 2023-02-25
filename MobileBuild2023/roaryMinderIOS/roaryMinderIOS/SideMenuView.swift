//
//  SideMenuView.swift
//  RoaryMinder
//
//  Created by Uriel Juarez on 2/25/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI


struct SideMenuView: View {
    @Binding var isHomePage: Bool
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16) {
            HStack {
                Button(action: {
                    isHomePage = true
                }) {
                    Image(systemName: "xmark")
                        .foregroundColor(.black)
                }
                .padding(.leading, 8)
                
                Spacer()
            }
            
            Button(action: {
                isHomePage = true
            }) {
                HStack {
                    Image(systemName: "house")
                        .foregroundColor(.blue)
                    
                    Text("My Courses")
                        .foregroundColor(.blue)
                }
                .padding(.leading, 8)
            }
            
            Button(action: {
                isHomePage = false
            }) {
                HStack {
                    Image(systemName: "list.bullet")
                        .foregroundColor(.blue)
                    
                    Text("All Classes")
                        .foregroundColor(.blue)
                }
                .padding(.leading, 8)
            }
            
            Spacer()
        }
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(
            Color(UIColor.systemBackground)
                .ignoresSafeArea()
                .transition(.move(edge: .leading))
        )
        .onTapGesture {
            isHomePage = true
        }
        .overlay(
            RoundedRectangle(cornerRadius: 10)
                .stroke(Color.gray.opacity(0.2), lineWidth: 2)
                .shadow(color: Color.gray.opacity(0.3), radius: 2, x: 0, y: 2)
        )
        .frame(maxWidth: UIScreen.main.bounds.width / 2)
    }
}




struct SideMenuView_Previews: PreviewProvider {
    static var previews: some View {
        SideMenuView(isHomePage: .constant(true))
            .previewLayout(.sizeThatFits)
            .padding()
    }
}
